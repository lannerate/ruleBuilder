package com.flagleader.builder.actions;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;

class aE
  implements MouseMoveListener
{
  aE(aq paramaq, Table paramTable)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    if (this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y)) != null)
      this.b.setCursor(new Cursor(null, 21));
    else
      this.b.setCursor(new Cursor(null, 0));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aE
 * JD-Core Version:    0.6.0
 */