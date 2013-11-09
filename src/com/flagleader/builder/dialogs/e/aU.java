package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aU extends MouseAdapter
{
  aU(aK paramaK)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (aK.h(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      aK.a(this.a, aK.g(this.a).getItem(localPoint));
      if (aK.i(this.a) == null)
        return;
      if (aK.j(this.a).getSelectionIndex() == 1)
        aK.k(this.a);
      else if (aK.i(this.a).getBounds(0).contains(localPoint))
        aK.a(this.a, aK.i(this.a), 0);
      else if (aK.i(this.a).getBounds(1).contains(localPoint))
        aK.a(this.a, aK.i(this.a), 1);
      else
        aK.k(this.a);
    }
    else
    {
      aK.l(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = aK.g(this.a).getItem(localPoint);
      if (localTableItem == null)
        aK.g(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aU
 * JD-Core Version:    0.6.0
 */