package org.agilemore.agilegrid;

import java.util.EventObject;
import org.eclipse.swt.events.MouseEvent;

public class I extends EventObject
{
  private MouseEvent a;
  private static final long b = -3900294537776357856L;

  public I(G paramG, MouseEvent paramMouseEvent)
  {
    super(paramG);
    this.a = paramMouseEvent;
  }

  public MouseEvent a()
  {
    return this.a;
  }

  public void a(MouseEvent paramMouseEvent)
  {
    this.a = paramMouseEvent;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.I
 * JD-Core Version:    0.6.0
 */