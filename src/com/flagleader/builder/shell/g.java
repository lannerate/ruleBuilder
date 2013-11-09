package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.repository.lang.info.InfoClass;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;

class g extends MouseAdapter
{
  g(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    TreeItem localTreeItem = this.a.f();
    Menu localMenu;
    MenuItem localMenuItem;
    if ((localTreeItem != null) && (!localTreeItem.isDisposed()) && (localTreeItem.getData() != null))
    {
      if (paramMouseEvent.button == 1)
      {
        ClassInfoEditor.a(this.a, (InfoClass)localTreeItem.getData());
        this.a.d();
        return;
      }
      if (paramMouseEvent.button == 3)
      {
        localMenu = com.flagleader.builder.widget.h.a();
        localMenuItem = new MenuItem(localMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("rename.popup"));
        localMenuItem.addSelectionListener(new h(this, localTreeItem));
        localMenuItem = new MenuItem(localMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("delete.popup"));
        localMenuItem.addSelectionListener(new i(this, localTreeItem));
        localMenuItem = new MenuItem(localMenu, 8);
        localMenuItem.setText(ResourceTools.getMessage("flush.popup"));
        localMenuItem.addSelectionListener(new j(this, localTreeItem));
        localMenu.setVisible(true);
        return;
      }
    }
    if (paramMouseEvent.button == 3)
    {
      localMenu = com.flagleader.builder.widget.h.a();
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("OpenItem"));
      localMenuItem.addSelectionListener(new k(this));
      localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(ResourceTools.getMessage("add.popup"));
      localMenuItem.addSelectionListener(new l(this));
      localMenu.setVisible(true);
      return;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.g
 * JD-Core Version:    0.6.0
 */