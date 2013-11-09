package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.a;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class z extends a
{
  public z(e parame)
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
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        e.e(this.a).showError(localException.getLocalizedMessage());
      }
  }

  public boolean b()
  {
    return !e.c(this.a);
  }

  public String c()
  {
    return "import";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.z
 * JD-Core Version:    0.6.0
 */