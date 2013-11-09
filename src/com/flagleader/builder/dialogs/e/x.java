package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Text;

class x extends SelectionAdapter
{
  x(w paramw)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell());
    localDirectoryDialog.setFilterPath(w.a(this.a).getText());
    if (localDirectoryDialog.open() == null)
      return;
    w.a(this.a).setText(localDirectoryDialog.getFilterPath());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.x
 * JD-Core Version:    0.6.0
 */