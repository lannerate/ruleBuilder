package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.M;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class fb extends MouseAdapter
{
  fb(eV parameV)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TreeItem localTreeItem = eV.c(this.a).getItem(localPoint);
    if (localTreeItem == null)
      return;
    int i = -1;
    for (int j = 1; j < eV.c(this.a).getColumnCount() + 1; j++)
    {
      if (!localTreeItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i > 0)
    {
      String str = localTreeItem.getText(i);
      if ((str != null) && (str.length() > 0))
      {
        M localM = new M(str, 0, 1);
        localM.open();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fb
 * JD-Core Version:    0.6.0
 */