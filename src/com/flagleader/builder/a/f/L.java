package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRelateRule;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class L extends a
{
  public L(o paramo)
  {
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls;*.xlsx" });
    String str = localFileDialog.open();
    if (str != null)
    {
      try
      {
        o.a(this.a).loadFieldFromExcel(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        o.b(this.a).showError(localException.getLocalizedMessage());
      }
      o.a(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !o.c(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.L
 * JD-Core Version:    0.6.0
 */