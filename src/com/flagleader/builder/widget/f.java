package com.flagleader.builder.widget;

import com.flagleader.builder.dialogs.M;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class f extends MouseAdapter
{
  f(e parame)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TreeItem localTreeItem = e.a(this.a).getItem(localPoint);
    if (localTreeItem == null)
      return;
    int i = -1;
    for (int j = 1; j < e.a(this.a).getColumnCount() + 1; j++)
    {
      if (!localTreeItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i > 0)
    {
      String str = localTreeItem.getText(i);
      if (localTreeItem.getData(String.valueOf(i)) == null)
        str = this.a.a(localTreeItem.getData(String.valueOf(i)));
      if ((str != null) && (str.length() > 0))
      {
        M localM = new M(this.a.a(localTreeItem.getData(String.valueOf(i))), 0, 1);
        localM.open();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.f
 * JD-Core Version:    0.6.0
 */