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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class aA extends MouseAdapter
{
  aA(aq paramaq, Tree paramTree)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    TreeItem localTreeItem = this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
    if ((localTreeItem != null) && (localTreeItem.getData() != null) && ((localTreeItem.getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)localTreeItem.getData();
      aq.e(this.a).getProjectTree().c(localITreeNode);
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y)) != null)
    {
      TreeItem localTreeItem = this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
      if (paramMouseEvent.button == 3)
      {
        aq.a(this.a, h.a());
        MenuItem localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_delete"));
        localMenuItem.addSelectionListener(new aB(this, localTreeItem));
        localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_delete_all"));
        localMenuItem.addSelectionListener(new aC(this, this.b));
        localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("table_goto"));
        localMenuItem.addSelectionListener(new aD(this, localTreeItem));
        aq.f(this.a).setVisible(true);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aA
 * JD-Core Version:    0.6.0
 */