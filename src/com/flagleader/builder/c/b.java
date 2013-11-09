package com.flagleader.builder.c;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.tree.Envionment;
import java.io.File;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class b extends MouseAdapter
{
  b(a parama)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (a.a(this.a).isLocked())
      return;
    if (a.b(this.a).getSelectionIndex() >= 0)
    {
      TableItem localTableItem = a.b(this.a).getSelection()[0];
      Object localObject;
      if (localTableItem.getText(0).toLowerCase().endsWith(".jar"))
      {
        localObject = new FileDialog(this.a.e(), 4096);
        ((FileDialog)localObject).setFilterExtensions(new String[] { "*.jar" });
        ((FileDialog)localObject).setFilterPath(new File(localTableItem.getText(0)).getParent());
        ((FileDialog)localObject).setFileName(new File(localTableItem.getText(0)).getName());
        if (((FileDialog)localObject).open() == null)
          return;
        File localFile = new File(((FileDialog)localObject).getFilterPath(), ((FileDialog)localObject).getFileName());
        localTableItem.setText(0, localFile.getPath());
      }
      else
      {
        localObject = new DirectoryDialog(this.a.e(), 0);
        ((DirectoryDialog)localObject).setFilterPath(localTableItem.getText(0));
        if (((DirectoryDialog)localObject).open() == null)
          return;
        localTableItem.setText(0, ((DirectoryDialog)localObject).getFilterPath());
      }
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (a.a(this.a).isLocked())
      return;
    if (paramMouseEvent.button == 3)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = a.b(this.a).getItem(localPoint);
      a.a(this.a, h.a());
      MenuItem localMenuItem = new MenuItem(a.c(this.a), 8);
      localMenuItem.setText(ResourceTools.getMessage("addJar.EnvionmentDialog", "add jar file"));
      localMenuItem.addListener(13, new c(this));
      localMenuItem = new MenuItem(a.c(this.a), 8);
      localMenuItem.setText(ResourceTools.getMessage("addDir.EnvionmentDialog", "add direction"));
      localMenuItem.addListener(13, new d(this));
      if (a.b(this.a).getSelectionIndex() >= 0)
      {
        localMenuItem = new MenuItem(a.c(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("delete.DataDialog", "delete"));
        localMenuItem.addListener(13, new e(this));
        localMenuItem = new MenuItem(a.c(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("moveUp.DataDialog", "move up"));
        localMenuItem.addListener(13, new f(this));
        localMenuItem = new MenuItem(a.c(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("moveDown.DataDialog", "move down"));
        localMenuItem.addListener(13, new g(this));
      }
      a.c(this.a).setEnabled(true);
      a.c(this.a).setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.b
 * JD-Core Version:    0.6.0
 */