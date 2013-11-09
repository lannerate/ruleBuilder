package com.flagleader.builder.c;

import com.flagleader.repository.tree.Envionment;
import java.io.File;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;

class c
  implements Listener
{
  c(b paramb)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    FileDialog localFileDialog = new FileDialog(b.a(this.a).e(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.jar" });
    if (localFileDialog.open() == null)
      return;
    File localFile = new File(localFileDialog.getFilterPath(), localFileDialog.getFileName());
    TableItem localTableItem = new TableItem(a.b(b.a(this.a)), 0);
    localTableItem.setText(0, localFile.getPath());
    a.a(b.a(this.a)).getClassDirVector().add(localFile.getPath());
    a.a(b.a(this.a)).setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.c
 * JD-Core Version:    0.6.0
 */