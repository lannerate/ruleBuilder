package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bt extends MouseAdapter
{
  bt(be parambe)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (be.l(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      be.a(this.a, be.k(this.a).getItem(localPoint));
      if (be.m(this.a) == null)
        return;
      be.n(this.a);
    }
    else
    {
      be.o(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = be.k(this.a).getItem(localPoint);
      if (localTableItem == null)
        be.k(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bt
 * JD-Core Version:    0.6.0
 */