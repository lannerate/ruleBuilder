package com.flagleader.builder.b;

import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.TableItem;

class i extends SelectionAdapter
{
  i(h paramh)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.jar" });
    if (localFileDialog.open() == null)
      return;
    File localFile = new File(localFileDialog.getFilterPath(), localFileDialog.getFileName());
    TableItem localTableItem = new TableItem(h.a(this.a), 0);
    localTableItem.setText(0, localFile.getPath());
    h.a(this.a, true);
    this.a.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.i
 * JD-Core Version:    0.6.0
 */