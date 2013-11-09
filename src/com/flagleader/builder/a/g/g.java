package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.IRuleSet;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class g extends com.flagleader.builder.a.c.a
{
  public g(a parama)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(a.e(this.a).getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str1 = a.b(this.a).getExcelFile();
    String str2 = new File(str1).getParent();
    String str3 = new File(str1).getName();
    localFileDialog.setFilterPath(str2);
    localFileDialog.setFileName(str3);
    str3 = localFileDialog.open();
    if (str3 != null)
      try
      {
        a.b(this.a).loadDataFromExcel(new File(str3));
        a.f(this.a).setModified(true);
        this.a.update();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.c(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !a.d(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.g
 * JD-Core Version:    0.6.0
 */