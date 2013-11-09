package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bJ extends MouseAdapter
{
  bJ(bE parambE)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (bE.f(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      bE.a(this.a, bE.e(this.a).getItem(localPoint));
      if (bE.g(this.a) == null)
        return;
      bE.h(this.a);
    }
    else
    {
      bE.i(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = bE.e(this.a).getItem(localPoint);
      if (localTableItem == null)
        bE.e(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bJ
 * JD-Core Version:    0.6.0
 */