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

class ac extends MouseAdapter
{
  private ac(Z paramZ)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = Z.c(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    if (localTableItem.getBounds(2).contains(localPoint))
      Z.a(this.a, localTableItem, 2, new ad(this, localTableItem));
    else if (localTableItem.getBounds(1).contains(localPoint))
      Z.a(this.a, localTableItem, 1, new ae(this, localTableItem));
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      Menu localMenu = h.a();
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = Z.c(this.a).getItem(localPoint);
      if (localTableItem != null)
      {
        int i = -1;
        for (int j = 1; j < Z.c(this.a).getColumnCount(); j++)
        {
          if (!localTableItem.getBounds(j).contains(localPoint))
            continue;
          i = j;
        }
        if (i > 0)
        {
          localMenuItem = new MenuItem(localMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
          localMenuItem.addListener(13, new af(this));
        }
      }
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.popup"));
      localMenuItem.addListener(13, new ag(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ac
 * JD-Core Version:    0.6.0
 */