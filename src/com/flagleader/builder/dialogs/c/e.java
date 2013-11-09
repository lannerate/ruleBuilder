package com.flagleader.builder.dialogs.c;

import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

class e extends SelectionAdapter
{
  e(d paramd)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    File localFile = new File(this.a.c.getText());
    String[] arrayOfString = { "*.xls" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
    if (localFile.exists())
    {
      localFileDialog.setFilterPath(localFile.getParent());
      localFileDialog.setFileName(localFile.getName());
    }
    String str = localFileDialog.open();
    if (str != null)
      this.a.c.setText(str);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.c.e
 * JD-Core Version:    0.6.0
 */