package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.ad;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.widgets.Control;

public class I extends J
{
  private String a = "unkown";

  protected I(e parame)
  {
    super(parame);
  }

  public void a(ad paramad)
  {
    if ("unkown".equals(this.a))
      a("normal");
    else if ("normal".equals(this.a))
      a("warning");
    else if ("warning".equals(this.a))
      a("delay");
    else if ("delay".equals(this.a))
      a("unkown");
    f();
  }

  protected Control a(e parame)
  {
    return null;
  }

  protected Object d()
  {
    return this.a;
  }

  protected void a(Object paramObject)
  {
    if ((paramObject == null) || ("".equals(paramObject)))
      return;
    this.a = ((String)paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.I
 * JD-Core Version:    0.6.0
 */