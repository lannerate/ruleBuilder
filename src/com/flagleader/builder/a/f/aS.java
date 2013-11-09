package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRule;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;

public class aS extends a
{
  public aS(aN paramaN)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(aN.a(this.a).getShell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str = localFileDialog.open();
    if (str != null)
    {
      try
      {
        aN.b(this.a).loadFieldFromExcel(str);
      }
      catch (Exception localException)
      {
        aN.c(this.a).showError(localException.getLocalizedMessage());
      }
      aN.b(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !aN.d(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aS
 * JD-Core Version:    0.6.0
 */