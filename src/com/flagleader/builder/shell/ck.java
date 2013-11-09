package com.flagleader.builder.shell;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class ck extends MouseAdapter
{
  private TreeItem b;

  ck(bX parambX)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (bX.l(this.a).getSelection().length > 0)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      this.b = bX.l(this.a).getItem(localPoint);
      if (this.b == null)
        return;
      if ((paramMouseEvent.button != 1) && (paramMouseEvent.button == 3))
        bX.b(this.a, this.b);
    }
    else
    {
      bX.l(this.a).setMenu(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ck
 * JD-Core Version:    0.6.0
 */