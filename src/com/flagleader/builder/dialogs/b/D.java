package com.flagleader.builder.dialogs.b;

import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

class D extends SelectionAdapter
{
  D(C paramC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    File localFile = new File(C.a(this.a).getText());
    String[] arrayOfString = { "*.xls", "*.xlsx" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
    if (localFile.exists())
    {
      localFileDialog.setFilterPath(localFile.getParent());
      localFileDialog.setFileName(localFile.getName());
    }
    String str = localFileDialog.open();
    if (str != null)
      C.a(this.a).setText(str);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.D
 * JD-Core Version:    0.6.0
 */