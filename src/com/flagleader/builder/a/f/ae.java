package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRelateRule;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class ae extends a
{
  public ae(X paramX)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(X.a(this.a).getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str = localFileDialog.open();
    if (str != null)
    {
      try
      {
        X.b(this.a).loadFieldFromExcel(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        X.c(this.a).showError(localException.getLocalizedMessage());
      }
      X.b(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !X.d(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ae
 * JD-Core Version:    0.6.0
 */