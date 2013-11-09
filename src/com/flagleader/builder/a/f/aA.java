package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRule;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class aA extends a
{
  public aA(af paramaf)
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
        af.a(this.a).loadFieldFromExcel(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        af.b(this.a).showError(localException.getLocalizedMessage());
      }
      af.a(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !af.c(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aA
 * JD-Core Version:    0.6.0
 */