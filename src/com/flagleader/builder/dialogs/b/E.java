package com.flagleader.builder.dialogs.b;

import com.flagleader.repository.db.SheetTable;
import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

class E extends SelectionAdapter
{
  E(C paramC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    File localFile = new File(C.b(this.a).getText());
    String[] arrayOfString = { "*.xls" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
    localFileDialog.setFilterExtensions(arrayOfString);
    if (localFile.exists())
    {
      localFileDialog.setFilterPath(localFile.getParent());
      localFileDialog.setFileName(localFile.getName());
    }
    else
    {
      localFileDialog.setFileName(this.a.a.getDisplayName());
    }
    String str = localFileDialog.open();
    if (str != null)
      C.b(this.a).setText(str);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.E
 * JD-Core Version:    0.6.0
 */