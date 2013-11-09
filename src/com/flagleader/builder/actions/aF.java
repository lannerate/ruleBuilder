package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aF extends MouseAdapter
{
  aF(aq paramaq, Table paramTable)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    TableItem localTableItem = this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
    if ((localTableItem != null) && (localTableItem.getData() != null) && ((localTableItem.getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)localTableItem.getData();
      aq.e(this.a).getProjectTree().c(localITreeNode);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y)) != null)
    {
      TableItem localTableItem = this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
      if (paramMouseEvent.button == 3)
      {
        aq.a(this.a, h.a());
        MenuItem localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_delete"));
        localMenuItem.addSelectionListener(new aG(this, localTableItem));
        localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_delete_all"));
        localMenuItem.addSelectionListener(new aH(this, this.b));
        localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_goto"));
        localMenuItem.addSelectionListener(new aI(this, localTableItem));
        aq.f(this.a).setVisible(true);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aF
 * JD-Core Version:    0.6.0
 */