package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.DecisionMultiRule;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class m extends com.flagleader.builder.a.c.a
{
  public m(a parama)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(a.a(this.a).getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str = localFileDialog.open();
    if (str != null)
    {
      try
      {
        a.b(this.a).loadFieldFromExcel(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.c(this.a).showError(localException.getLocalizedMessage());
      }
      a.b(this.a).setModified(true);
      this.a.update();
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
 * Qualified Name:     com.flagleader.builder.a.f.m
 * JD-Core Version:    0.6.0
 */