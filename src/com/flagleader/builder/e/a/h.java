package com.flagleader.builder.e.a;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class h extends MouseAdapter
{
  h(g paramg)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    g.a(this.a, g.a(this.a).getItem(localPoint));
    if (g.b(this.a) == null)
      return;
    if (g.b(this.a).getBounds(3).contains(localPoint))
      g.a(this.a, g.b(this.a), 3);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = g.a(this.a).getItem(localPoint);
      if (localTableItem == null)
        g.a(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.a.h
 * JD-Core Version:    0.6.0
 */