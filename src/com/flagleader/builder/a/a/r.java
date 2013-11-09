package com.flagleader.builder.a.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class r extends MouseAdapter
{
  private r(o paramo)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = o.a(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    if (localTableItem.getBounds(4).contains(localPoint))
      o.a(this.a, localTableItem, 4, new s(this, localTableItem));
    else if (localTableItem.getBounds(0).contains(localPoint))
      o.a(this.a, localTableItem, 0, new t(this, localTableItem));
    else if (localTableItem.getBounds(3).contains(localPoint))
      o.a(this.a, localTableItem, 3, new u(this, localTableItem));
    else if (localTableItem.getBounds(1).contains(localPoint))
      o.a(this.a, localTableItem, 1, new v(this, localTableItem));
    else if (localTableItem.getBounds(2).contains(localPoint))
      o.a(this.a, localTableItem, 2, new w(this, localTableItem));
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      Menu localMenu = h.a();
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("add.DataDialog", "add"));
      localMenuItem.addListener(13, new x(this));
      if ((o.a(this.a).getSelectionIndex() >= 0) && (o.a(this.a).getSelectionCount() == 1))
      {
        localMenuItem = new MenuItem(localMenu, 2);
        localMenuItem = new MenuItem(localMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("delete.DataDialog", "delete"));
        localMenuItem.addListener(13, new y(this));
      }
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.popup"));
      localMenuItem.addListener(13, new z(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.r
 * JD-Core Version:    0.6.0
 */