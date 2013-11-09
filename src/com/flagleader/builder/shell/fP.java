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

class fP extends MouseAdapter
{
  fP(fE paramfE)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if ((this.a.e != null) && (!this.a.e.isDisposed()))
        this.a.e.dispose();
      this.a.e = new Menu(fE.h(this.a).getShell(), 8);
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = fE.h(this.a).getItem(localPoint);
      if (localTableItem != null)
      {
        int i = -1;
        for (int j = 1; j < fE.h(this.a).getColumnCount() + 1; j++)
        {
          if (!localTableItem.getBounds(j).contains(localPoint))
            continue;
          i = j;
        }
        if (i > 0)
        {
          j = i;
          MenuItem localMenuItem = new MenuItem(this.a.e, 8);
          localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
          localMenuItem.addListener(13, new fQ(this, localTableItem, j));
        }
      }
      this.a.e.setEnabled(true);
      this.a.e.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fP
 * JD-Core Version:    0.6.0
 */