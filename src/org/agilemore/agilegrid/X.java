package org.agilemore.agilegrid;

import org.agilemore.agilegrid.a.p;
import org.eclipse.swt.widgets.Composite;

public class X extends a
{
  public X(e parame)
  {
    this(parame, false);
  }

  public X(e parame, boolean paramBoolean)
  {
    super(parame, paramBoolean);
  }

  public boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 < this.b.w().a()) && (paramInt2 >= 0) && (paramInt2 < this.b.w().b());
  }

  public J a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, null);
  }

  public J a(int paramInt1, int paramInt2, Object paramObject)
  {
    return new p(this.b);
  }

  public Object c(int paramInt1, int paramInt2)
  {
    return this.b.v(paramInt1, paramInt2);
  }

  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    this.b.b(paramInt1, paramInt2, paramObject);
  }

  protected Composite a(Composite paramComposite)
  {
    return null;
  }

  protected boolean b(G paramG)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.X
 * JD-Core Version:    0.6.0
 */