package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ev extends MouseAdapter
{
  ev(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if ((this.a.i != null) && (!this.a.i.isDisposed()))
        this.a.i.dispose();
      this.a.i = new Menu(this.a.g.getShell(), 8);
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = this.a.g.getItem(localPoint);
      if (localTableItem != null)
      {
        int i = -1;
        for (int j = 1; j < this.a.g.getColumnCount() + 1; j++)
        {
          if (!localTableItem.getBounds(j).contains(localPoint))
            continue;
          i = j;
        }
        if (i > 0)
        {
          j = i;
          MenuItem localMenuItem = new MenuItem(this.a.i, 8);
          localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
          localMenuItem.addListener(13, new ew(this, localTableItem, j));
        }
      }
      this.a.i.setEnabled(true);
      this.a.i.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ev
 * JD-Core Version:    0.6.0
 */