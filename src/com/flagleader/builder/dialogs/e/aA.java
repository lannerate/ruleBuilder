package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aA extends MouseAdapter
{
  aA(as paramas)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (as.g(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      as.a(this.a, as.f(this.a).getItem(localPoint));
      if (as.h(this.a) == null)
        return;
      if (as.h(this.a).getBounds(0).contains(localPoint))
        as.a(this.a, as.h(this.a), 0);
      else if (as.h(this.a).getBounds(1).contains(localPoint))
        as.a(this.a, as.h(this.a), 1);
      else
        as.i(this.a);
    }
    else
    {
      as.j(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = as.f(this.a).getItem(localPoint);
      if (localTableItem == null)
        as.f(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aA
 * JD-Core Version:    0.6.0
 */