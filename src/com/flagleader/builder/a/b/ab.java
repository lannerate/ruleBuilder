package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import java.util.List;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ab extends MouseAdapter
{
  ab(aa paramaa)
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
        for (int j = 1; j < aa.c(this.a).size() + 1; j++)
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
          localMenuItem.addListener(13, new ac(this, str));
        }
      }
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("update.popup"));
      localMenuItem.addListener(13, new ad(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.ab
 * JD-Core Version:    0.6.0
 */