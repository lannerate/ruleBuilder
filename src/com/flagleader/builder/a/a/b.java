package com.flagleader.builder.a.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.db.ISelectObject;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class b extends MouseAdapter
{
  b(a parama)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      Menu localMenu = h.a();
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = this.a.e.getItem(localPoint);
      if (localTableItem != null)
      {
        int i = -1;
        for (int j = 1; j < this.a.e().getFieldNames().length + 1; j++)
        {
          if (!localTableItem.getBounds(j).contains(localPoint))
            continue;
          i = j;
        }
        if (i > 0)
        {
          String str = localTableItem.getText(i);
          localMenuItem = new MenuItem(localMenu, 8);
          localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
          localMenuItem.addListener(13, new c(this, str));
        }
      }
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.edit"));
      localMenuItem.addListener(13, new d(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.b
 * JD-Core Version:    0.6.0
 */