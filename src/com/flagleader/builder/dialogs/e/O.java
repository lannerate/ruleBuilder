package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class O extends MouseAdapter
{
  O(C paramC)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (C.g(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      C.a(this.a, C.f(this.a).getItem(localPoint));
      if (C.h(this.a) == null)
        return;
      if (C.a(this.a).getSourceSheet() != null)
      {
        if (C.h(this.a).getBounds(0).contains(localPoint))
          C.a(this.a, C.h(this.a), 0);
        else
          C.i(this.a);
      }
      else if (C.h(this.a).getBounds(3).contains(localPoint))
        C.i(this.a);
      else if (C.h(this.a).getBounds(0).contains(localPoint))
        C.b(this.a, C.h(this.a), 0);
      else if (C.h(this.a).getBounds(1).contains(localPoint))
        C.b(this.a, C.h(this.a), 1);
      else if (C.h(this.a).getBounds(2).contains(localPoint))
        C.b(this.a, C.h(this.a), 2);
    }
    else
    {
      C.j(this.a);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = C.f(this.a).getItem(localPoint);
      if (localTableItem == null)
        C.f(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.O
 * JD-Core Version:    0.6.0
 */