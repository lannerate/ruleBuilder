package com.flagleader.builder.dialogs;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Text;

class F extends SelectionAdapter
{
  F(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell(), 0);
    localDirectoryDialog.setFilterPath(z.e(this.a).getText());
    if (localDirectoryDialog.open() != null)
      z.e(this.a).setText(localDirectoryDialog.getFilterPath());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.F
 * JD-Core Version:    0.6.0
 */