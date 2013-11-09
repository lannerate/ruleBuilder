package com.flagleader.builder.a;

import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.p;
import com.flagleader.repository.IElement;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class az extends MouseAdapter
{
  az(ax paramax)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Table localTable = ax.a(this.a).getTable();
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = localTable.getItem(localPoint);
    if (localTableItem == null)
      return;
    TableTreeItem localTableTreeItem = ax.a(this.a).getItem(localPoint);
    int i = localTable.getColumnCount();
    for (int j = 0; j < i; j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      int k = this.a.a(j, (IElement)localTableTreeItem.getData());
      if (k == 1)
      {
        ax.a(this.a, new p(this.a.a()).a(localTable, 4));
        ax.e(this.a).setFont(localTable.getFont());
        ax.e(this.a).setText(localTableItem.getText(j));
        ax.a(this.a, localTableItem, ax.e(this.a), ax.f(this.a), j);
        ax.a(this.a, localTableTreeItem);
        ax.e(this.a).setFocus();
      }
      else
      {
        if (k != 2)
          continue;
        ax.a(this.a, new CCombo(localTable, 0));
        ax.a(this.a, localTableTreeItem);
        ax.a(this.a, ax.a(this.a).getItem(localPoint), localTableItem, ax.g(this.a), ax.f(this.a), j);
        ax.g(this.a).setFocus();
      }
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    this.a.setChanged();
    this.a.notifyObservers();
    super.mouseUp(paramMouseEvent);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint;
    TableTreeItem localTableTreeItem;
    if (paramMouseEvent.button == 1)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTableTreeItem = ax.a(this.a).getItem(localPoint);
      if ((localTableTreeItem == null) || (localTableTreeItem.getData() == null))
        ax.a(this.a).setSelection(new TableTreeItem[0]);
    }
    if (paramMouseEvent.button == 3)
    {
      localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      localTableTreeItem = ax.a(this.a).getItem(localPoint);
      TableItem localTableItem = ax.a(this.a).getTable().getItem(localPoint);
      int i = ax.a(this.a).getTable().getColumnCount();
      int j = -1;
      for (int k = 0; k < i; k++)
      {
        if ((localTableItem == null) || (!localTableItem.getBounds(k).contains(localPoint)))
          continue;
        j = k;
        break;
      }
      Menu localMenu = h.a();
      if (localTableTreeItem == null)
      {
        ax.a(this.a).setSelection(new TableTreeItem[0]);
        this.a.a(localMenu, null, j);
      }
      else if (ax.a(this.a).getSelectionCount() == 1)
      {
        this.a.a(localMenu, new IElement[] { (IElement)localTableTreeItem.getData() }, j);
      }
      else if (ax.a(this.a).getSelectionCount() > 1)
      {
        this.a.a(localMenu, this.a.k(), j);
      }
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
      return;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.az
 * JD-Core Version:    0.6.0
 */