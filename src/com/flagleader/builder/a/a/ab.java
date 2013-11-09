package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.db.SheetMap;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class ab extends a
{
  public ab(Z paramZ)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        this.a.a(new File(str));
        this.a.q().setModified(true);
        this.a.q().updateViewer();
        this.a.q().updateTree();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Z.b(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !Z.a(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ab
 * JD-Core Version:    0.6.0
 */