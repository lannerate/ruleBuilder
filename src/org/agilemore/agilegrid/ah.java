package org.agilemore.agilegrid;

import java.util.EventObject;

public class ah extends EventObject
{
  private static final long a = -5047979651521824055L;
  private G b;
  private G c;

  public ah(Object paramObject, G paramG1, G paramG2)
  {
    super(paramObject);
    this.b = paramG1;
    this.c = paramG2;
  }

  public G a()
  {
    return this.b;
  }

  public G b()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.ah
 * JD-Core Version:    0.6.0
 */