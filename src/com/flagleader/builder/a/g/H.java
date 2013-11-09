package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.TestCaseLib;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class H extends a
{
  public H(B paramB)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(B.e(this.a).getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str1 = B.b(this.a).getExcelFile();
    String str2 = new File(str1).getParent();
    String str3 = new File(str1).getName();
    localFileDialog.setFilterPath(str2);
    localFileDialog.setFileName(str3);
    str3 = localFileDialog.open();
    if (str3 != null)
      try
      {
        B.b(this.a).loadDataFromExcel(new File(str3));
        B.b(this.a).setModified(true);
        B.b(this.a).updateViewer();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        B.c(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !B.d(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.H
 * JD-Core Version:    0.6.0
 */