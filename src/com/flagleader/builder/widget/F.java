package com.flagleader.builder.widget;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.M;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class F extends MouseAdapter
{
  F(E paramE)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = E.a(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = -1;
    for (int j = 1; j < E.a(this.a).getColumnCount() + 1; j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i > 0)
    {
      String str = localTableItem.getText(i);
      if ((str != null) && (str.length() > 0))
        new M(str, 0, 1).open();
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (E.a(this.a).getItem(new Point(paramMouseEvent.x, paramMouseEvent.y)) != null)
    {
      TableItem localTableItem = E.a(this.a).getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
      if (paramMouseEvent.button == 3)
      {
        E.a(this.a, h.a());
        MenuItem localMenuItem = new MenuItem(E.b(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_delete"));
        localMenuItem.addSelectionListener(new G(this, localTableItem));
        localMenuItem = new MenuItem(E.b(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_delete_all"));
        localMenuItem.addSelectionListener(new H(this));
        E.b(this.a).setVisible(true);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.F
 * JD-Core Version:    0.6.0
 */