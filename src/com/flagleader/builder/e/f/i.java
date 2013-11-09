package com.flagleader.builder.e.f;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class i extends MouseAdapter
{
  i(h paramh)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    h.a(this.a, h.a(this.a).getItem(localPoint));
    if (h.b(this.a) == null)
      return;
    if (h.b(this.a).getBounds(3).contains(localPoint))
      h.a(this.a, h.b(this.a), 3);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = h.a(this.a).getItem(localPoint);
      if (localTableItem == null)
        h.a(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.f.i
 * JD-Core Version:    0.6.0
 */