package com.flagleader.builder.shell;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class fe extends MouseAdapter
{
  fe(eV parameV)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fe
 * JD-Core Version:    0.6.0
 */