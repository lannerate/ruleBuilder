package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ai extends MouseAdapter
{
  ai(Y paramY)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (Y.i(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      Y.a(this.a, Y.h(this.a).getItem(localPoint));
      if (Y.j(this.a) == null)
        return;
      if (Y.g(this.a).getSelectionIndex() == 1)
        Y.k(this.a);
      else if (Y.j(this.a).getBounds(0).contains(localPoint))
        Y.a(this.a, Y.j(this.a), 0);
      else if (Y.j(this.a).getBounds(1).contains(localPoint))
        Y.a(this.a, Y.j(this.a), 1);
      else
        Y.k(this.a);
    }
    else
    {
      Y.l(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = Y.h(this.a).getItem(localPoint);
      if (localTableItem == null)
        Y.h(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ai
 * JD-Core Version:    0.6.0
 */