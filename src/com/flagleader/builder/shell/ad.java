package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.p;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class ad extends MouseAdapter
{
  ad(aa paramaa, Table paramTable, TableEditor paramTableEditor)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if ((this.a.d != null) && (!this.a.d.isDisposed()))
        this.a.d.dispose();
      this.a.d = new Menu(this.b.getShell(), 8);
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = this.b.getItem(localPoint);
      if (localTableItem != null)
      {
        int i = -1;
        for (int j = 1; j < this.b.getColumnCount() + 1; j++)
        {
          if (!localTableItem.getBounds(j).contains(localPoint))
            continue;
          i = j;
        }
        if (i > 0)
        {
          j = i;
          MenuItem localMenuItem = new MenuItem(this.a.d, 8);
          localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
          localMenuItem.addListener(13, new ae(this, localTableItem, j));
        }
      }
      this.a.d.setEnabled(true);
      this.a.d.setVisible(true);
    }
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = this.b.getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = -1;
    for (int j = 1; j < this.b.getColumnCount() + 1; j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i > 0)
    {
      aa.a(this.a, new p().a(this.b, 4));
      aa.f(this.a).setFont(this.b.getFont());
      aa.f(this.a).setText(localTableItem.getText(i));
      aa.a(this.a, localTableItem, aa.f(this.a), this.c, i);
      aa.f(this.a).setFocus();
    }
    else
    {
      aa.c(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ad
 * JD-Core Version:    0.6.0
 */