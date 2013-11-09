package com.flagleader.builder.b;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.TableItem;

class j extends SelectionAdapter
{
  j(h paramh)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell(), 0);
    if (localDirectoryDialog.open() == null)
      return;
    TableItem localTableItem = new TableItem(h.a(this.a), 0);
    localTableItem.setText(0, localDirectoryDialog.getFilterPath());
    h.a(this.a, true);
    this.a.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.j
 * JD-Core Version:    0.6.0
 */