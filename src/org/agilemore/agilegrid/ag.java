package org.agilemore.agilegrid;

import java.util.EventObject;

public class ag extends EventObject
{
  private static final long c = 1L;
  public boolean a;
  public J b;

  public ag(Object paramObject, J paramJ, boolean paramBoolean)
  {
    super(paramObject);
    this.b = paramJ;
    this.a = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.ag
 * JD-Core Version:    0.6.0
 */