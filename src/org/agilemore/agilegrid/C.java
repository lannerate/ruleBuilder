package org.agilemore.agilegrid;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

class C extends MouseAdapter
{
  C(A paramA)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    this.a.a(paramMouseEvent, 3);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    this.a.a(paramMouseEvent, 2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.C
 * JD-Core Version:    0.6.0
 */