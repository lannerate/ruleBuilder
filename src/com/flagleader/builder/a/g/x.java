package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.TestCaseLib;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class x extends a
{
  public x(r paramr)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(r.e(this.a).getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str1 = r.b(this.a).getExcelFile();
    String str2 = new File(str1).getParent();
    String str3 = new File(str1).getName();
    localFileDialog.setFilterPath(str2);
    localFileDialog.setFileName(str3);
    str3 = localFileDialog.open();
    if (str3 != null)
      try
      {
        r.b(this.a).loadDataFromExcel(new File(str3));
        r.b(this.a).setModified(true);
        r.b(this.a).updateViewer();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        r.c(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !r.d(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.x
 * JD-Core Version:    0.6.0
 */