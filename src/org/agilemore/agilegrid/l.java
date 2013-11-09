package org.agilemore.agilegrid;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

class l extends MouseAdapter
{
  l(e parame)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    this.a.a(paramMouseEvent);
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    this.a.d(paramMouseEvent);
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    this.a.b(paramMouseEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.l
 * JD-Core Version:    0.6.0
 */