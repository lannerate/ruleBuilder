package org.agilemore.agilegrid.a;

import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.ad;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.widgets.Control;

public class a extends J
{
  private boolean a = false;
  private static final int n = 0;

  public a(e parame)
  {
    super(parame, 0);
  }

  public a(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  public void a(ad paramad)
  {
    a(Boolean.valueOf(!this.a));
    f();
  }

  protected Control a(e parame)
  {
    return null;
  }

  protected Object d()
  {
    return this.a ? Boolean.TRUE : Boolean.FALSE;
  }

  protected void a(Object paramObject)
  {
    this.a = ((Boolean)paramObject).booleanValue();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.a
 * JD-Core Version:    0.6.0
 */