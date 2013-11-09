package com.flagleader.builder.b;

import java.io.File;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class n extends MouseAdapter
{
  n(h paramh)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (h.a(this.a).getSelectionIndex() >= 0)
    {
      TableItem localTableItem = h.a(this.a).getSelection()[0];
      Object localObject;
      if (localTableItem.getText(0).toLowerCase().endsWith(".jar"))
      {
        localObject = new FileDialog(this.a.getShell(), 4096);
        ((FileDialog)localObject).setFilterExtensions(new String[] { "*.jar" });
        ((FileDialog)localObject).setFilterPath(new File(localTableItem.getText(0)).getParent());
        ((FileDialog)localObject).setFileName(new File(localTableItem.getText(0)).getName());
        if (((FileDialog)localObject).open() == null)
          return;
        File localFile = new File(((FileDialog)localObject).getFilterPath(), ((FileDialog)localObject).getFileName());
        localTableItem.setText(0, localFile.getPath());
        h.a(this.a, true);
        this.a.a();
      }
      else
      {
        localObject = new DirectoryDialog(this.a.getShell(), 0);
        ((DirectoryDialog)localObject).setFilterPath(localTableItem.getText(0));
        if (((DirectoryDialog)localObject).open() == null)
          return;
        localTableItem.setText(0, ((DirectoryDialog)localObject).getFilterPath());
        h.a(this.a, true);
        this.a.a();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.n
 * JD-Core Version:    0.6.0
 */