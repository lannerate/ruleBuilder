package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.b.H;
import com.flagleader.repository.rlm.value.SheetWhere;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bW extends MouseAdapter
{
  bW(bS parambS)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (bS.f(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      bS.a(this.a, bS.e(this.a).getItem(localPoint));
      if (bS.g(this.a) == null)
        return;
      Rectangle localRectangle = bS.g(this.a).getBounds(2);
      if (localRectangle.contains(localPoint))
      {
        H localH = new H(this.a.getShell(), bS.h(this.a), (SheetWhere)bS.f(this.a).getData());
        if (localH.open() == 0)
          bS.g(this.a).setText(2, ((SheetWhere)bS.f(this.a).getData()).getValue());
      }
      else
      {
        bS.i(this.a);
      }
    }
    else
    {
      bS.j(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = bS.e(this.a).getItem(localPoint);
      if (localTableItem == null)
        bS.e(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bW
 * JD-Core Version:    0.6.0
 */