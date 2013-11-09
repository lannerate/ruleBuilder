package com.flagleader.builder.a.d;

import com.flagleader.builder.widget.h;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class s extends MouseAdapter
{
  s(o paramo)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TreeItem localTreeItem = this.a.e.getItem(localPoint);
    if (localTreeItem == null)
      return;
    if (!localTreeItem.equals(this.a.g))
    {
      this.a.g = localTreeItem;
      return;
    }
    int i = this.a.e.getColumnCount();
    for (int j = 0; j < i; j++)
    {
      if (!localTreeItem.getBounds(j).contains(localPoint))
        continue;
      this.a.a(localTreeItem, j);
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    o.a(this.a);
    this.a.notifyObservers();
    super.mouseUp(paramMouseEvent);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint;
    TreeItem localTreeItem;
    if (paramMouseEvent.button == 1)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTreeItem = this.a.e.getItem(localPoint);
      if ((localTreeItem == null) || (localTreeItem.getData() == null))
        this.a.e.setSelection(new TreeItem[0]);
      if (localTreeItem != null)
        this.a.g = localTreeItem;
    }
    if (paramMouseEvent.button == 3)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTreeItem = this.a.e.getItem(localPoint);
      Menu localMenu = h.a();
      if (localTreeItem == null)
      {
        this.a.e.setSelection(new TreeItem[0]);
        this.a.a(localMenu, null);
      }
      else if (this.a.e.getSelectionCount() == 1)
      {
        this.a.a(localMenu, new Item[] { localTreeItem });
      }
      else if (this.a.e.getSelectionCount() > 1)
      {
        this.a.a(localMenu, this.a.e.getSelection());
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
      return;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.s
 * JD-Core Version:    0.6.0
 */