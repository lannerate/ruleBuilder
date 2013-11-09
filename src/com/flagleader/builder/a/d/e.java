package com.flagleader.builder.a.d;

import com.flagleader.builder.widget.h;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class e extends MouseAdapter
{
  e(a parama)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = this.a.e.getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = this.a.e.getColumnCount();
    for (int j = 0; j < i; j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      this.a.a(localTableItem, j);
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    a.a(this.a);
    this.a.notifyObservers();
    super.mouseUp(paramMouseEvent);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint;
    TableItem localTableItem;
    if (paramMouseEvent.button == 1)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTableItem = this.a.e.getItem(localPoint);
      if ((localTableItem == null) || (localTableItem.getData() == null))
        this.a.e.setSelection(new TableItem[0]);
    }
    if (paramMouseEvent.button == 3)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTableItem = this.a.e.getItem(localPoint);
      Menu localMenu = h.a();
      if (localTableItem == null)
      {
        this.a.e.setSelection(new TableItem[0]);
        this.a.a(localMenu, null);
      }
      else if (this.a.e.getSelectionCount() == 1)
      {
        this.a.a(localMenu, new Item[] { localTableItem });
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
 * Qualified Name:     com.flagleader.builder.a.d.e
 * JD-Core Version:    0.6.0
 */