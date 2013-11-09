package com.flagleader.builder.e.g;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class g extends MouseAdapter
{
  g(f paramf)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    f.a(this.a, f.a(this.a).getItem(localPoint));
    if (f.b(this.a) == null)
      return;
    if (f.b(this.a).getBounds(3).contains(localPoint))
      f.a(this.a, f.b(this.a), 3);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = f.a(this.a).getItem(localPoint);
      if (localTableItem == null)
        f.a(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.g.g
 * JD-Core Version:    0.6.0
 */