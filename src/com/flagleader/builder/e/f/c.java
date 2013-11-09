package com.flagleader.builder.e.f;

import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

class c extends SelectionAdapter
{
  c(b paramb)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String[] arrayOfString = { "*.dbs" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
    if (com.flagleader.manager.d.b.a().B() != null)
    {
      File localFile1 = new File(com.flagleader.manager.d.b.a().B());
      if (localFile1.exists())
      {
        localFileDialog.setFilterPath(localFile1.getParent());
        localFileDialog.setFileName(localFile1.getName());
      }
      String str = localFileDialog.open();
      if (str != null)
      {
        File localFile2 = new File(str);
        b.a(this.a).setText(localFile2.getPath());
        this.a.a(localFile2);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.f.c
 * JD-Core Version:    0.6.0
 */