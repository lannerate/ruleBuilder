package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.db.SheetTable;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class V extends a
{
  public V(M paramM)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(this.a.e.getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.csv;*.xlsx" });
    String str1 = this.a.f().getExcelFile();
    String str2 = new File(str1).getParent();
    String str3 = new File(str1).getName();
    localFileDialog.setFilterPath(str2);
    localFileDialog.setFileName(str3);
    str3 = localFileDialog.open();
    if (str3 != null)
      try
      {
        this.a.f().saveValues(this.a.f().loadDataFromExcel(new File(str3)));
        this.a.f().setModified(true);
        this.a.f().updateViewer();
        this.a.f().updateTree();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        M.a(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !M.b(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.V
 * JD-Core Version:    0.6.0
 */